Function isaccessversion%(arg0$)
    Local local0.versions
    For local0 = Each versions
        If (lower(local0\Field0) = lower(arg0)) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
