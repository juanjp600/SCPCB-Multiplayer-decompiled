Function voice_playsound%(arg0$, arg1#, arg2%)
    Local local0%
    If (filesize(arg0) < $2D) Then
        Return $00
    EndIf
    local0 = alcreatesource(arg0, $01, (arg2 = $00))
    If (local0 <> $00) Then
        If (arg2 = $00) Then
            alsourceplay(local0, $01)
            alsourcesetvolume(local0, 0.0)
        Else
            alsourceplay(local0, $01)
            alsourcesetvolume(local0, arg1)
        EndIf
    EndIf
    Return local0
    Return $00
End Function
