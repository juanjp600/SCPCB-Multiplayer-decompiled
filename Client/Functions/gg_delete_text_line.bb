Function gg_delete_text_line%(arg0%)
    Local local0.tgg_textline
    Local local1%
    local0 = gg_find_text_line(arg0)
    If (local0 = Null) Then
        Return $00
    EndIf
    For local1 = $01 To len(local0\Field1) Step $01
        freeentity(local0\Field2[local1])
    Next
    freeentity(local0\Field0)
    Delete local0
    Return $00
End Function
