Function f2s$(arg0#, arg1%)
    Local local0#
    If (arg1 <= $00) Then
        Return (Str (Int arg0))
    EndIf
    local0 = 1.0
    Select arg1
        Case $01
            local0 = 10.0
        Case $02
            local0 = 100.0
        Case $03
            local0 = 1000.0
        Default
            local0 = (10.0 ^ (Float arg1))
    End Select
    Return (Str (floor((arg0 * local0)) / local0))
    Return ""
End Function
