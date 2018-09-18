
# Create your tests here.
'''from django.test import TestCase
import unittest

class MyTests(TestCase):
    @classmethod
    def setUpTestData(cls):
        # Set up data for the whole TestCase
        #cls.foo = Foo.objects.create(bar="Test")


    def test1(self):
        # Some test using self.foo


    def test2(self):
        # Some other test using self.foo



    class SimpleTest(unittest.TestCase):
        def test_details(self):
            client = Client()
            response = client.get('/customer/details/')
            self.assertEqual(response.status_code, 200)

        def test_index(self):
            client = Client()
            response = client.get('/customer/index/')
            self.assertEqual(response.status_code, 200)'''


from django.contrib.auth.models import AnonymousUser, User
from django.test import TestCase

class SearchFormTestCase(TestCase):
    def test_empty_get(self):
        response = self.client.get('/echo_thrift', HTTP_HOST='http://127.0.0.1:8000')
        self.assertEqual(response.status_code, 400)

    def test_empty_get1(self):
            response = self.client.get('/en/dev/search/', HTTP_HOST='docs.djangoproject.dev:8000')
            self.assertEqual(response.status_code, 400)