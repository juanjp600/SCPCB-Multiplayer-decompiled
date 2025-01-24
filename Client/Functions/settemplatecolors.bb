Function settemplatecolors%(arg0%, arg1%, arg2%)
    Local local0.template
    local0 = (Object.template arg0)
    local0\Field37 = ((arg1 And $FF0000) Sar $10)
    local0\Field38 = ((arg1 And $FF00) Sar $08)
    local0\Field39 = (arg1 And $FF)
    local0\Field40 = ((arg2 And $FF0000) Sar $10)
    local0\Field41 = ((arg2 And $FF00) Sar $08)
    local0\Field42 = (arg2 And $FF)
    Return $00
End Function
