Function updateemitters%()
    Local local0.emitters
    For local0 = Each emitters
        local0\Field13 = (local0\Field13 - fpsfactor)
        If (1.0 > local0\Field13) Then
            removeemitter(local0)
        EndIf
    Next
    Return $00
End Function
