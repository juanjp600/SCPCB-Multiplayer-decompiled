Function var_getid%()
    Local local0%
    For local0 = $01 To $1FF Step $01
        If (s_variables[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
