Function loadmesh_strict%(arg0$, arg1%, arg2%)
    Local local0%
    Local local1%
    If (arg2 <> 0) Then
        Return loadrawmesh(arg0, arg1)
    EndIf
    If (filetype(arg0) <> $01) Then
        runtimeerror((("3D Mesh " + arg0) + " not found."))
    EndIf
    local0 = loadmesh(arg0, $00)
    If (local0 = $00) Then
        runtimeerror(("Failed to load 3D Mesh: " + arg0))
    EndIf
    local1 = createtexture($01, $01, $00, $01)
    entitytexture(local0, local1, $00, $00)
    freetexture(local1)
    Return local0
    Return $00
End Function
