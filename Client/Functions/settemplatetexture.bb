Function settemplatetexture%(arg0%, arg1$, arg2%, arg3%)
    Local local0.template
    local0 = (Object.template arg0)
    local0\Field8 = loadtexture_strict(arg1, arg2)
    Return $00
End Function
