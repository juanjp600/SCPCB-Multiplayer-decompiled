Function var_remove%(arg0$)
    Local local0%
    For local0 = $01 To $1FF Step $01
        If (s_variables[local0] <> Null) Then
            If (s_variables[local0]\Field0 = arg0) Then
                Delete s_variables[local0]
                Return $00
            EndIf
        EndIf
    Next
    Return $00
End Function
