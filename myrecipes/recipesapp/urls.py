from django.urls import path
from . import rest_facade

urlpatterns = [
        path('backend/1/receta', rest_facade.get_recetas, name='get_receta'),
]