Function freetemplate%(arg0%)
    Local local0.template
    Local local1%
    local0 = (Object.template arg0)
    If (local0\Field8 <> 0) Then
        freetexture(local0\Field8)
    EndIf
    For local1 = $00 To $07 Step $01
        If (local0\Field0[local1] <> Null) Then
            freetemplate((Handle local0\Field0[local1]))
        EndIf
    Next
    Delete local0
    Return $00
End Function
