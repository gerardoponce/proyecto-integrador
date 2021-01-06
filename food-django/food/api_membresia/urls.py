from django.urls import path
from . import views

urlpatterns = [
    path('overview', views.apiOverview, name="membresia-overview"),
    path('crear', views.crearMembresia, name="membresia-crear"),
    path('', views.listarMembresias, name="membresias-listar"),
    path('<str:nombre>', views.listarMembresia, name="membresia-listar"),
    path('<str:nombre>/actualizar', views.actualizarMembresia, name="membresia-actualizar"),
    path('<str:nombre>/eliminar', views.eliminarMembresia, name="membresia-eliminar")
]
