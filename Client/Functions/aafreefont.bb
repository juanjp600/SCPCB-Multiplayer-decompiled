Function aafreefont%(arg0%)
    Local local0.aafont
    local0 = (Object.aafont arg0)
    If (local0 <> Null) Then
        freefont(local0\Field7)
        If (aatextenable = $00) Then
            freetexture(local0\Field1)
            freeimage(local0\Field2)
        EndIf
        Delete local0
    EndIf
    Return $00
End Function
