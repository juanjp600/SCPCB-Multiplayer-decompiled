Function loadsound_strict%(arg0$)
    Local local0.sounds
    Local local1%
    If (filesize(arg0) = $00) Then
        Return $00
    EndIf
    local0 = (New sounds)
    local0\Field0 = loadsound(arg0)
    soundvolume(local1, 0.0)
    Return (Handle local0)
    Return $00
End Function
