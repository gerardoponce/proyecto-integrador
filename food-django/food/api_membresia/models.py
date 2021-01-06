from django.db import models

# Create your models here.

class Membresia(models.Model):
    nombre = models.CharField(max_length=200)
    descripcion = models.CharField(max_length=200)
    precio = models.DecimalField(max_digits=5, decimal_places=2)
    
    objects = models.Manager()
    def __str__(self):
        return self.nombre
