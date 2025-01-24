Function calculateroomtemplateextents%(arg0.roomtemplates)
    If (arg0\Field9 <> 0) Then
        Return $00
    EndIf
    getmeshextents(getchild(arg0\Field0, $02))
    arg0\Field10 = mesh_minx
    arg0\Field11 = mesh_miny
    arg0\Field12 = mesh_minz
    arg0\Field13 = mesh_maxx
    arg0\Field14 = mesh_maxy
    arg0\Field15 = mesh_maxz
    Return $00
End Function
