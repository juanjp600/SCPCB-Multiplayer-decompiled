Function drawdebugline%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%, arg7%, arg8%, arg9%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4.debugger
    local0 = (arg3 - arg0)
    local1 = (arg4 - arg1)
    local2 = (arg5 - arg2)
    local3 = (sqr((((local0 * local0) + (local1 * local1)) + (local2 * local2))) * 0.5)
    local4 = (New debugger)
    local4\Field0 = copyentity(g_debugcube, $00)
    local4\Field2 = arg9
    positionentity(local4\Field0, arg0, arg1, arg2, $00)
    aligntovector(local4\Field0, local0, local1, local2, $03, 1.0)
    scaleentity(local4\Field0, 0.2, 0.2, local3, $00)
    entitycolor(local4\Field0, (Float arg6), (Float arg7), (Float arg8))
    entityfx(local4\Field0, $09)
    local4\Field1 = copyentity(g_debugcube, local4\Field0)
    positionentity(local4\Field1, 0.0, 0.0, 0.0, $00)
    scaleentity(local4\Field1, 0.5, 0.5, 0.99, $00)
    entitycolor(local4\Field1, 255.0, 255.0, 255.0)
    entityorder(local4\Field1, $FFFFFFFF)
    entityfx(local4\Field1, $01)
    showentity(local4\Field0)
    Return $00
End Function
