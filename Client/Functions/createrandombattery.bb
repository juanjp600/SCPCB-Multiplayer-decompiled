Function createrandombattery.items(arg0#, arg1#, arg2#)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    local2 = ((selecteddifficulty\Field4 * $05) + $0A)
    local3 = rand(local2, $01)
    If (((local3 > $00) And (local3 <= $05)) <> 0) Then
        local0 = "9V Battery"
        local1 = $50
    ElseIf (((local3 > $05) And (local3 < (local2 - $02))) <> 0) Then
        local0 = "4.5V Battery"
        local1 = $51
    Else
        local0 = "18V Battery"
        local1 = $52
    EndIf
    Return createitem(local0, local1, arg0, arg1, arg2, $00, $00, $00, 1.0, $00)
    Return Null
End Function
