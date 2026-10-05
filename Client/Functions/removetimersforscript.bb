Function removetimersforscript%(arg0.se_script)
    Local local0.timers
    If (arg0 = Null) Then
        Return $00
    EndIf
    For local0 = Each timers
        If (local0\Field0 = arg0) Then
            removetimer(local0)
        EndIf
    Next
    Return $00
End Function
