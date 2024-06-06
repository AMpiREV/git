import xml.dom.minidom as minidom
import xml.sax
import tkinter as tk
from tkinter import messagebox, simpledialog, filedialog

class StudentRecord:
    def __init__(self, student_last_name, father_last_name, mother_last_name, father_income, mother_income, brothers, sisters):
        self.student_last_name = student_last_name
        self.father_last_name = father_last_name
        self.mother_last_name = mother_last_name
        self.father_income = int(father_income)
        self.mother_income = int(mother_income)
        self.brothers = int(brothers)
        self.sisters = int(sisters)

class StudentRecordModel:
    def __init__(self):
        self.records = []

    def add_record(self, record):
        self.records.append(record)

    def delete_records(self, condition):
        initial_len = len(self.records)
        self.records = [record for record in self.records if not condition(record)]
        return initial_len - len(self.records)

    def search_records(self, condition):
        return [record for record in self.records if condition(record)]

    def save_to_file(self, file_path):
        doc = minidom.Document()
        root = doc.createElement('StudentRecords')
        doc.appendChild(root)

        for record in self.records:
            record_element = doc.createElement('Record')
            root.appendChild(record_element)

            for key, value in record.__dict__.items():
                elem = doc.createElement(key)
                elem.appendChild(doc.createTextNode(str(value)))
                record_element.appendChild(elem)

        with open(file_path, 'w') as f:
            f.write(doc.toprettyxml(indent="  "))

    def load_from_file(self, file_path):
        self.records = []
        handler = StudentRecordHandler(self)
        parser = xml.sax.make_parser()
        parser.setContentHandler(handler)
        parser.parse(file_path)

class StudentRecordHandler(xml.sax.ContentHandler):
    def __init__(self, model):
        self.model = model
        self.current_data = ""
        self.current_record = {}
        self.mapping = {
            'student_last_name': 'student_last_name',
            'father_last_name': 'father_last_name',
            'mother_last_name': 'mother_last_name',
            'father_income': 'father_income',
            'mother_income': 'mother_income',
            'brothers': 'brothers',
            'sisters': 'sisters'
        }

    def startElement(self, tag, attributes):
        self.current_data = tag
        if tag == "Record":
            self.current_record = {}

    def endElement(self, tag):
        if tag == "Record":
            record = StudentRecord(
                self.current_record['student_last_name'],
                self.current_record['father_last_name'],
                self.current_record['mother_last_name'],
                self.current_record['father_income'],
                self.current_record['mother_income'],
                self.current_record['brothers'],
                self.current_record['sisters']
            )
            self.model.add_record(record)
        self.current_data = ""

    def characters(self, content):
        if self.current_data in self.mapping:
            self.current_record[self.mapping[self.current_data]] = content

class StudentRecordView(tk.Tk):
    def __init__(self, controller=None):
        super().__init__()
        self.controller = controller
        self.title("Student Records")
        self.geometry("800x600")

        self.records_per_page = 10
        self.current_page = 0

        self.create_widgets()

    def create_widgets(self):
        self.record_listbox = tk.Listbox(self, width=100, height=20)
        self.record_listbox.pack()

        self.pagination_frame = tk.Frame(self)
        self.pagination_frame.pack()

        self.first_button = tk.Button(self.pagination_frame, text="<<", command=self.first_page)
        self.first_button.pack(side=tk.LEFT)

        self.prev_button = tk.Button(self.pagination_frame, text="<", command=self.prev_page)
        self.prev_button.pack(side=tk.LEFT)

        self.next_button = tk.Button(self.pagination_frame, text=">", command=self.next_page)
        self.next_button.pack(side=tk.LEFT)

        self.last_button = tk.Button(self.pagination_frame, text=">>", command=self.last_page)
        self.last_button.pack(side=tk.LEFT)

        self.add_button = tk.Button(self, text="Add Record", command=self.add_record)
        self.add_button.pack()

        self.search_button = tk.Button(self, text="Search Records", command=self.search_records)
        self.search_button.pack()

        self.delete_button = tk.Button(self, text="Delete Records", command=self.delete_records)
        self.delete_button.pack()

        self.save_button = tk.Button(self, text="Save Records", command=self.save_records)
        self.save_button.pack()

        self.load_button = tk.Button(self, text="Load Records", command=self.load_records)
        self.load_button.pack()

    def update_record_list(self, records):
        self.record_listbox.delete(0, tk.END)
        for record in records:
            record_str = f"Student: {record.student_last_name}, Father: {record.father_last_name} (${record.father_income}), Mother: {record.mother_last_name} (${record.mother_income}), Brothers: {record.brothers}, Sisters: {record.sisters}"
            self.record_listbox.insert(tk.END, record_str)

    def first_page(self):
        self.current_page = 0
        self.controller.update_view()

    def prev_page(self):
        if self.current_page > 0:
            self.current_page -= 1
            self.controller.update_view()

    def next_page(self):
        if self.current_page < (len(self.controller.model.records) - 1) // self.records_per_page:
            self.current_page += 1
            self.controller.update_view()

    def last_page(self):
        self.current_page = (len(self.controller.model.records) - 1) // self.records_per_page
        self.controller.update_view()

    def add_record(self):
        self.controller.add_record()

    def delete_records(self):
        self.controller.delete_records()

    def search_records(self):
        self.controller.search_records()

    def save_records(self):
        self.controller.save_records()

    def load_records(self):
        self.controller.load_records()

class StudentRecordController:
    def __init__(self, model, view):
        self.model = model
        self.view = view
        self.view.controller = self

    def add_record(self):
        student_last_name = simpledialog.askstring("Input", "Enter student's last name:")
        father_last_name = simpledialog.askstring("Input", "Enter father's last name:")
        mother_last_name = simpledialog.askstring("Input", "Enter mother's last name:")
        father_income = simpledialog.askinteger("Input", "Enter father's income:")
        mother_income = simpledialog.askinteger("Input", "Enter mother's income:")
        brothers = simpledialog.askinteger("Input", "Enter number of brothers:")
        sisters = simpledialog.askinteger("Input", "Enter number of sisters:")

        if None not in (student_last_name, father_last_name, mother_last_name, father_income, mother_income, brothers, sisters):
            record = StudentRecord(student_last_name, father_last_name, mother_last_name, father_income, mother_income, brothers, sisters)
            self.model.add_record(record)
            self.update_view()
        else:
            messagebox.showwarning("Input error", "All fields must be filled.")

    def delete_records(self):
        search_by = simpledialog.askstring("Input", "Enter the criteria for deletion (student_last_name, father_last_name, mother_last_name, brothers, sisters, father_income, mother_income):")
        search_value = simpledialog.askstring("Input", f"Enter the value for {search_by}:")

        if search_by in ["student_last_name", "father_last_name", "mother_last_name"]:
            condition = lambda record: getattr(record, search_by) == search_value
        elif search_by in ["brothers", "sisters", "father_income", "mother_income"]:
            condition = lambda record: getattr(record, search_by) == int(search_value)
        else:
            messagebox.showerror("Input error", "Invalid criteria.")
            return

        deleted_count = self.model.delete_records(condition)
        messagebox.showinfo("Deletion result", f"Deleted {deleted_count} records.")
        self.update_view()

    def search_records(self):
        search_by = simpledialog.askstring("Input", "Enter the criteria for search (student_last_name, father_last_name, mother_last_name, brothers, sisters, father_income, mother_income):")
        search_value = simpledialog.askstring("Input", f"Enter the value for {search_by}:")

        if search_by in ["student_last_name", "father_last_name", "mother_last_name"]:
            condition = lambda record: getattr(record, search_by) == search_value
        elif search_by in ["brothers", "sisters", "father_income", "mother_income"]:
            condition = lambda record: getattr(record, search_by) == int(search_value)
        else:
            messagebox.showerror("Input error", "Invalid criteria.")
            return

        results = self.model.search_records(condition)
        if results:
            result_str = "\n".join([f"Student: {r.student_last_name}, Father: {r.father_last_name} (${r.father_income}), Mother: {r.mother_last_name} (${r.mother_income}), Brothers: {r.brothers}, Sisters: {r.sisters}" for r in results])
            messagebox.showinfo("Search results", result_str)
        else:
            messagebox.showinfo("Search results", "No records found.")

    def save_records(self):
        file_path = filedialog.asksaveasfilename(defaultextension=".xml", filetypes=[("XML files", "*.xml")])
        if file_path:
            self.model.save_to_file(file_path)
            messagebox.showinfo("Save result", "Records saved successfully.")

    def load_records(self):
        file_path = filedialog.askopenfilename(defaultextension=".xml", filetypes=[("XML files", "*.xml")])
        if file_path:
            self.model.load_from_file(file_path)
            self.update_view()
            messagebox.showinfo("Load result", "Records loaded successfully.")

    def update_view(self):
        start_index = self.view.current_page * self.view.records_per_page
        end_index = start_index + self.view.records_per_page
        self.view.update_record_list(self.model.records[start_index:end_index])

if __name__ == "__main__":
    model = StudentRecordModel()
    view = StudentRecordView()  # Создаем вид без контроллера
    controller = StudentRecordController(model, view)  # Создаем контроллер и связываем его с видом
    view.mainloop()  # Запускаем основной цикл приложения
