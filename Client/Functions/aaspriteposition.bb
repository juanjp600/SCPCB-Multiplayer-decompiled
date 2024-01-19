Function aaspriteposition%(arg0%, arg1%, arg2%)
    Local local0#
    Local local1#
    local0 = (((Float (arg1 - (aacamvieww Sar $01))) / (Float aacamvieww)) * 2.0)
    local1 = (- (((Float (arg2 - (aacamviewh Sar $01))) / (Float aacamvieww)) * 2.0))
    local0 = ((local0 - ((1.0 / (Float aacamvieww)) * (Float ((aacharw - $02) Mod $02)))) + (1.0 / (Float aacamvieww)))
    local1 = ((local1 - ((1.0 / (Float aacamvieww)) * (Float ((aacharh - $02) Mod $02)))) + (1.0 / (Float aacamvieww)))
    positionentity(aatextsprite[arg0], local0, local1, 1.0, $00)
    Return $00
End Function
