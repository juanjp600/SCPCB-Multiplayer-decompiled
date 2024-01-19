Function var_setvalue%(arg0$, arg1$)
    Local local0%
    For local0 = $01 To $1FF Step $01
        If (s_variables[local0] <> Null) Then
            If (s_variables[local0]\Field0 = arg0) Then
                s_variables[local0]\Field1 = arg1
                Return $00
            EndIf
        EndIf
    Next
    local0 = var_getid()
    If (local0 = $00) Then
        Return $00
    EndIf
    s_variables[local0] = (New servervariables)
    s_variables[local0]\Field0 = arg0
    s_variables[local0]\Field1 = arg1
    Return $00
End Function
