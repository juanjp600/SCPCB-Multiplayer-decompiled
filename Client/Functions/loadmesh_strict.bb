Function loadmesh_strict%(arg0$, arg1%)
    Local local0%
    If (filetype(arg0) <> $01) Then
        runtimeerror((("3D Mesh " + arg0) + " not found."))
    EndIf
    local0 = loadmesh(arg0, arg1)
    If (local0 = $00) Then
        runtimeerror(("Failed to load 3D Mesh: " + arg0))
    EndIf
    Return local0
    Return $00
End Function
