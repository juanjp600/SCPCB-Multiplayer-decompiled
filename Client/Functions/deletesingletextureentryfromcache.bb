Function deletesingletextureentryfromcache%(arg0%, arg1%)
    Local local0.textureincache
    For local0 = Each textureincache
        If (((local0\Field0 = arg0) And (local0\Field2 <= arg1)) <> 0) Then
            If (local0\Field0 <> $00) Then
                freetexture(local0\Field0)
                local0\Field0 = $00
            EndIf
            Delete local0
        EndIf
    Next
    Return $00
End Function
