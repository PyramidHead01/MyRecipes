import json
from .models import Recipe

from django.http import HttpResponse,HttpResponseNotAllowed, JsonResponse

# from django.views.decorators.csrf import csrf_exempt

# @csrf_exempt
def get_recetas(request):

    if request.method != 'GET':
        return HttpResponseNotAllowed(['GET'])

    lista_de_recetas = mostrar_lista_recetas()

    json = []
    for receta in lista_de_recetas:
        json.append({'nombre': receta.nombre, 'descripcion': receta.descripcion})

    return JsonResponse(json, safe=False, status=200)

def mostrar_lista_recetas():
    try:
        return Recipe.objects.all()
    except Recipe.DoesNotExist:
        return None 