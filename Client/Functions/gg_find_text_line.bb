Function gg_find_text_line.tgg_textline(arg0%)
    Local local0.tgg_textline
    For local0 = Each tgg_textline
        If (local0\Field0 = arg0) Then
            Return local0
        EndIf
    Next
    Return Null
    Return Null
End Function
