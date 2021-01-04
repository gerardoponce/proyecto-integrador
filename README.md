# Versión inicial del proyecto FOOD en Android
Para ejecutar cada vista por separado:

1) Ir a AndroidManifest.xml, y encontrar esta parte:

 **activity android:name=".MainActivity"**
        
2) Reemplazar ".MainActivity" por cualquiera de los siguientes:
   - **MainAdminDesayunos** , para CRUD de Desayunos
    - **MainAdminAlmuerzos** , para CRUD de Almuerzos
   - **MainAdminPostres** , para CRUD de Postres
   
   - **RecyclerActivityDesayunos** , para vista de usuario regular en categoría desayunos
    - **RecyclerActivityAlmuerzos** , para vista de usuario regular en categoría Almuerzos
   - **RecyclerActivityPostres** , para vista de usuario regular en categoría Postres
   
   -**MainHome** , para ver la "página principal" con BottomNavigationView
        

