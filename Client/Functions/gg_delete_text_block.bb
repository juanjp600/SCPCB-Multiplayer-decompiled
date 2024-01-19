Function gg_delete_text_block%(arg0%)
    Local local0.tgg_textline
    For local0 = Each tgg_textline
        If (getparent(local0\Field0) = arg0) Then
            gg_delete_text_line(local0\Field0)
        EndIf
    Next
    freeentity(arg0)
    Return $00
End Function
