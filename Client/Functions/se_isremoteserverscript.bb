Function se_isremoteserverscript%(arg0.se_script)
    Local local0.scriptsthread
    If (arg0 = Null) Then
        Return $00
    EndIf
    For local0 = Each scriptsthread
        If (local0\Field0 = arg0) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
