from django.db import models

# Create your models here.
class Recipe(models.Model):
        nombre = models.CharField(max_length=50)
        descripcion = models.CharField(max_length=500)

# añade esto
def __str__(self):
    return self.nombre