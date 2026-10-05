Function loadrawanimmesh%(arg0$, arg1%)
    Local local0%
    Local local1%
    If (filetype(arg0) <> $01) Then
        runtimeerror((("3D Animated Mesh " + arg0) + " not found."))
    EndIf
    local0 = loadmesh(arg0, $00)
    If (local0 = $00) Then
        runtimeerror(("Failed to load 3D Animated Mesh: " + arg0))
    EndIf
    local1 = animlength(local0)
    getmeshextents(local0)
    freeentity(local0)
    local0 = createcube($00)
    scalemesh(local0, mesh_maxx, (mesh_maxy / 2.0), mesh_maxz)
    positionmesh(local0, 0.0, (mesh_maxy / 2.0), 0.0)
    entityparent(local0, arg1, $01)
    addanimseq(local0, local1)
    setanimtime(local0, 0.0, $00)
    Return local0
    Return $00
End Function
