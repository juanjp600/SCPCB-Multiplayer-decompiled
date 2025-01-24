Function deletetextureentriesfromcache%(arg0%)
    Local local0.textureincache
    Local local1.materials
    For local0 = Each textureincache
        If (local0\Field2 <= arg0) Then
            If (local0\Field0 <> $00) Then
                freetexture(local0\Field0)
                local0\Field0 = $00
            EndIf
            Delete local0
        EndIf
    Next
    For local1 = Each materials
        local1\Field1 = $00
    Next
    Return $00
End Function
