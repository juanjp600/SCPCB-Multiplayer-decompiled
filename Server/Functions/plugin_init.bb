Function plugin_init%(arg0$)
    Local local0.plugin
    local0 = (New plugin)
    lastpluginid = (lastpluginid + $01)
    local0\Field0 = lastpluginid
    local0\Field1 = arg0
    local0\Field2 = createbank($00)
    plugins[local0\Field0] = local0
    Return local0\Field0
    Return $00
End Function
