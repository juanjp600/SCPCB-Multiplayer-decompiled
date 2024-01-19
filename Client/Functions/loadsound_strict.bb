Function loadsound_strict%(arg0$)
    Local local0$
    Local local1.redirectedsound
    Local local2.sound
    local0 = lower(arg0)
    For local1 = Each redirectedsound
        If (local0 = local1\Field2) Then
            arg0 = local1\Field1
            Exit
        EndIf
    Next
    local2 = (New sound)
    local2\Field1 = arg0
    local2\Field0 = $00
    local2\Field4 = $00
    If (enablesfxrelease = $00) Then
        If (local2\Field0 = $00) Then
            local2\Field0 = loadsound(local2\Field1)
        EndIf
    EndIf
    Return (Handle local2)
    Return $00
End Function
