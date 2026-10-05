Function se_readsafestring$(arg0%)
    Local local0%
    If (se_canread(arg0, $04) = $00) Then
        Return ""
    EndIf
    local0 = readint(arg0)
    If (((local0 < $00) Or (local0 > $1000)) <> 0) Then
        se_loadinvalid = $01
        Return ""
    EndIf
    If (se_canread(arg0, local0) = $00) Then
        Return ""
    EndIf
    seekfile(arg0, (filepos(arg0) - $04))
    Return readstring(arg0)
    Return ""
End Function
