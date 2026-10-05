Function checkcidrrange%(arg0$, arg1$)
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local0 = instr(arg1, "/", $01)
    If (local0 = $00) Then
        Return $00
    EndIf
    local1 = left(arg1, (local0 - $01))
    local2 = (Int mid(arg1, (local0 + $01), $FFFFFFFF))
    If (((local2 < $00) Or (local2 > $20)) <> 0) Then
        Return $00
    EndIf
    local3 = iptodecimal(arg0)
    local4 = iptodecimal(local1)
    local5 = ($FFFFFFFF Shl ($20 - local2))
    If ((local3 And local5) = (local4 And local5)) Then
        Return $01
    EndIf
    Return $00
    Return $00
End Function
