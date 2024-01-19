Function loadsound_global%(arg0$)
    Local local0.globalloadedsound
    Local local1$
    Local local2.redirectedsound
    Local local3%
    For local0 = Each globalloadedsound
        If (local0\Field0 = arg0) Then
            Return local0\Field1
        EndIf
    Next
    local1 = lower(arg0)
    For local2 = Each redirectedsound
        If (local1 = local2\Field2) Then
            arg0 = local2\Field1
            Exit
        EndIf
    Next
    local3 = loadsound(arg0)
    If (local3 = $00) Then
        Return $00
    EndIf
    local0 = (New globalloadedsound)
    local0\Field0 = arg0
    local0\Field1 = local3
    Return local0\Field1
    Return $00
End Function
