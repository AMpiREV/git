import unittest
from unittest.mock import MagicMock, patch
from main import StudentRecordModel, StudentRecord, StudentRecordController

class TestStudentRecordModel(unittest.TestCase):
    def setUp(self):
        self.model = StudentRecordModel()

    def test_add_record(self):
        record = StudentRecord("Doe", "John", "Jane", 50000, 45000, 2, 1)
        self.model.add_record(record)
        self.assertEqual(len(self.model.records), 1)
        self.assertEqual(self.model.records[0].student_last_name, "Doe")

    def test_delete_records(self):
        record1 = StudentRecord("Doe", "John", "Jane", 50000, 45000, 2, 1)
        record2 = StudentRecord("Smith", "Paul", "Anna", 60000, 55000, 1, 3)
        self.model.add_record(record1)
        self.model.add_record(record2)
        deleted_count = self.model.delete_records(lambda r: r.student_last_name == "Doe")
        self.assertEqual(deleted_count, 1)
        self.assertEqual(len(self.model.records), 1)
        self.assertEqual(self.model.records[0].student_last_name, "Smith")

    def test_search_records(self):
        record1 = StudentRecord("Doe", "John", "Jane", 50000, 45000, 2, 1)
        record2 = StudentRecord("Smith", "Paul", "Anna", 60000, 55000, 1, 3)
        self.model.add_record(record1)
        self.model.add_record(record2)
        results = self.model.search_records(lambda r: r.student_last_name == "Smith")
        self.assertEqual(len(results), 1)
        self.assertEqual(results[0].student_last_name, "Smith")

class TestStudentRecordController(unittest.TestCase):
    def setUp(self):
        self.model = StudentRecordModel()
        self.view = MagicMock()
        self.controller = StudentRecordController(self.model, self.view)


if __name__ == '__main__':
    unittest.main()
