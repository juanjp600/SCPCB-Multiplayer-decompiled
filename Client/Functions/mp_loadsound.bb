Function mp_loadsound%(arg0$, arg1%)
    Local local0.mp_sound
    Local local1%
    arg0 = lower(arg0)
    If (arg1 <> 0) Then
        For local0 = Each mp_sound
            If (local0\Field0 = arg0) Then
                Return (Handle local0)
            EndIf
        Next
    EndIf
    local1 = loadsound(arg0)
    If (local1 = $00) Then
        Return $00
    EndIf
    local0 = (New mp_sound)
    local0\Field0 = arg0
    local0\Field1 = local1
    Return (Handle local0)
    Return $00
End Function
