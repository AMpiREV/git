## Лабораторная работа №2 Вариант 10

### Описание
-Разработать оконное приложение с одним главным окном и несколькими дочерними диалогами. Вызов диалогов осуществляется через соответствующие пункты меню. Команды меню должны дублироваться на панели инструментов. 
#### Цель:  

- Изучить основные возможности языка Python для разработки программных систем с интерфейсом командной строки (CLI) 
- Разработать программную систему на языке Python согласно описанию предметной области

#### Задачи: 

- Приложение должно быть построено при помощи шаблона проектирования Model-View-Controller
- Приложение должно уметь:
    1. Формировать массив записей путем ввода записей через окна диалога.
    2. Осуществлять поиск записей в массиве в соответствие с условиями, указанными в отдельном диалоговом окне (не в диалоге удаления)
    3. В варианте задания условия поиска должны вводиться в специальном диалоговом окне, результат поиска выводиться в нём же с помощью стандартных элементов управления.
    4. Удалять запись из массива по условиям, указанным в варианте. Условия удаления должны вводиться в отдельном диалоговом окне (не в диалоге поиска).
    5. Пользователю должно сообщаться о том были ли удалены записи, и сколько было удалено, согласно введенным условиям или таких записей не было найдено.
    6. Отображать весь текущий массив записей в главном окне приложения.
    7. Сохранять и загружать массив записей из указываемого пользователем файла, посредством стандартного диалога сохранения/загрузки. Формат хранения данных в файле XML. Для записи использовать DOM парсер, для чтения SAX парсер.
    8. Для хранения должны использоваться правильные типы. Например, в таблице написано, что поле будет содержать дату рождения, значит, при реализации должен использоваться тип дата для данного поля. На диалогах для ввода даты должен использоваться специальный компонент для ввода дат. Например, календарь, чтобы дату было удобно создать. Если поле хранит число. Например, возраст, значит нужно использовать целочисленный атрибут для хранения возраста.
    9. Вывод записей в главном окне и в диалоге поиска осуществляется в постраничном виде. Например, по 10 записей на странице. Элемент управления страницами должен позволять переходить на первую, последнюю, следующую и предыдущую страницы, должен позволять изменить число записей на странице и показывать текущее число записей на странице, а также должен показывать число всех доступных записей и номер текущей активной страницы, а также число всех доступных страниц.

- условия поиска и удаления:
    1. по ФИО студента (Может быть заполнен только один элемент ФИО, например имя);
    2. по ФИО одного из родителей. (Может быть заполнен только один элемент ФИО, например имя);
    3. по числу братьев или сестер;
    4. по размеру заработка одного из родителей (Задается нижняя или верхняя граница, или обе)

### Релизация

- ### Model
  Состоит из трёх классов:
  -StudentRecord
  ```python
    class StudentRecord:
    def __init__(self, student_last_name, father_last_name, mother_last_name, father_income, mother_income, brothers, sisters):
        self.student_last_name = student_last_name
        self.father_last_name = father_last_name
        self.mother_last_name = mother_last_name
        self.father_income = int(father_income)
        self.mother_income = int(mother_income)
        self.brothers = int(brothers)
        self.sisters = int(sisters)
  ```
  -StudentRecordModel
  ```python
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
  ```
  -StudentRecordHandler
  ```python
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
  ```
- ### View
  Состоит из класса StudentRecordView в котором создаётся ползовательский интерфейс:
  ```python
  class StudentRecordView(tk.Tk):
    def __init__(self, controller=None):
        super().__init__()
        self.controller = controller
        self.title("Student Records")
        self.geometry("800x600")

        self.records_per_page = 10
        self.current_page = 0

        self.create_widgets()
  ```
- ### Controller
  Состоит из класса StudentRecordController в котором и происходят все основные логические операции
  -add_record
  ```python
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
  ```
  -delete_records
  ```python
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
  ```
  -search_records
  ```python
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
  ```
  -save_records
  ```python
      def save_records(self):
        file_path = filedialog.asksaveasfilename(defaultextension=".xml", filetypes=[("XML files", "*.xml")])
        if file_path:
            self.model.save_to_file(file_path)
            messagebox.showinfo("Save result", "Records saved successfully.")
  ```
  -load_records
  ```python
      def load_records(self):
        file_path = filedialog.askopenfilename(defaultextension=".xml", filetypes=[("XML files", "*.xml")])
        if file_path:
            self.model.load_from_file(file_path)
            self.update_view()
            messagebox.showinfo("Load result", "Records loaded successfully.")
  ```
  -update_view
  ```python
      def update_view(self):
        start_index = self.view.current_page * self.view.records_per_page
        end_index = start_index + self.view.records_per_page
        self.view.update_record_list(self.model.records[start_index:end_index])
  ```
