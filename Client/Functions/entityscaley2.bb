Function entityscaley2#(arg0%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    local0 = getmatelement(arg0, $01, $00)
    local1 = getmatelement(arg0, $01, $01)
    local2 = getmatelement(arg0, $01, $02)
    local3 = sqr((((local0 * local0) + (local1 * local1)) + (local2 * local2)))
    Return local3
    Return 0.0
End Function
