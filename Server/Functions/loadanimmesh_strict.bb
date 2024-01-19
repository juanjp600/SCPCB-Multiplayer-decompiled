Function loadanimmesh_strict%(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2%
    If (filetype(arg0) <> $01) Then
        runtimeerror((("3D Animated Mesh " + arg0) + " not found."))
    EndIf
    local0 = loadanimmesh(arg0, $00)
    If (local0 = $00) Then
        runtimeerror(("Failed to load 3D Animated Mesh: " + arg0))
    EndIf
    local1 = animlength(local0)
    freeentity(local0)
    local0 = loadmesh(arg0, $00)
    local2 = loadtexture_strict(arg0, $01)
    entitytexture(local0, local2, $00, $00)
    freetexture(local2)
    addanimseq(local0, local1)
    setanimtime(local0, 0.0, $00)
    Return local0
    Return $00
End Function
