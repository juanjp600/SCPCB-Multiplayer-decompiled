Function gg_find_character.tgg_character(arg0.tgg_font, arg1$)
    Local local0.tgg_character
    For local0 = Each tgg_character
        If (((local0\Field1 = arg0) And ((local0\Field2 = arg1) Or (local0\Field2 = "DUMMY"))) <> 0) Then
            Return local0
        EndIf
    Next
    Return Null
    Return Null
End Function
