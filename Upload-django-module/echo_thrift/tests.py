
# Create your tests here.
from django.test import TestCase

class MyTests(TestCase):
    @classmethod
    def setUpTestData(cls):
        # Set up data for the whole TestCase
        cls.foo = Foo.objects.create(bar="Test")
        ...

    def test1(self):
        # Some test using self.foo
        ...

    def test2(self):
        # Some other test using self.foo

        ...

    import unittest
    from django.test

    class SimpleTest(unittest.TestCase):
        def test_details(self):
            client = Client()
            response = client.get('/customer/details/')
            self.assertEqual(response.status_code, 200)

        def test_index(self):
            client = Client()
            response = client.get('/customer/index/')
            self.assertEqual(response.status_code, 200)