Function addtexturetocache%(arg0%)
    Local local0.materials
    Local local1$
    local0 = getcache(strippath(texturename(arg0)))
    If (local0 = Null) Then
        local0 = (New materials)
        local0\Field0 = strippath(texturename(arg0))
        If (bumpenabled <> 0) Then
            local1 = getinistring("Data\materials.ini", local0\Field0, "bump", "")
            If (local1 <> "") Then
                local0\Field2 = loadtexture_strict(local1, $01)
            Else
                local0\Field2 = $00
            EndIf
        EndIf
        local0\Field1 = $00
    EndIf
    If (local0\Field1 = $00) Then
        local0\Field1 = arg0
    EndIf
    Return $00
End Function
