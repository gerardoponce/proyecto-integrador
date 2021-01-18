from rest_framework.decorators import api_view
from rest_framework.response import Response
from .serializers import MembresiaSerializer
from .models import Membresia

# Create your views here.

"""
API Overview
"""
@api_view(['GET'])
def apiOverview(request):
    api_urls = {
        'Listar todos' : '',
        'Listar uno' : '<str:pk>',
        'Crear' : 'crear',
        'Actualizar' : '<str:pk>/actualizar',
        'Eliminar' : '<str:pk>/eliminar',
    }
    return Response(api_urls)

@api_view(['POST'])
def crearMembresia(request):
    serializer = MembresiaSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)

@api_view(['GET'])
def listarMembresias(request):
    membresias = Membresia.objects.all()
    serializer = MembresiaSerializer(membresias, many = True)
    return Response(serializer.data)

@api_view(['GET'])
def listarMembresia(request, nombre):
    membresia = Membresia.objects.get(nombre=nombre)
    serializer = MembresiaSerializer(membresia, many = False)
    return Response(serializer.data)

@api_view(['GET'])
def listarMembresiaPorId(request, id):
    membresia = Membresia.objects.get(id=id)
    serializer = MembresiaSerializer(membresia, many = False)
    return Response(serializer.data)

@api_view(['PUT'])
def actualizarMembresia(request, nombre):
    membresia = Membresia.objects.get(nombre=nombre)
    serializer = MembresiaSerializer(instance=membresia, data=request.data)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)

@api_view(['DELETE'])
def eliminarMembresia(request, nombre):
    membresia = Membresia.objects.get(nombre=nombre)
    membresia.delete()
    return Response("Membresia eliminada.")
