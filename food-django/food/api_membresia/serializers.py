from rest_framework import serializers

from .models import Membresia

class MembresiaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Membresia
        fields = '__all__'
