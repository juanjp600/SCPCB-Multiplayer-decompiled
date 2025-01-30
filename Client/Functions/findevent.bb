Function findevent.events(arg0%)
    Local local0.events
    For local0 = Each events
        If (local0\Field0 = arg0) Then
            Return local0
        EndIf
    Next
    Return Null
    Return Null
End Function
