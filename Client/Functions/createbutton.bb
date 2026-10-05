Function createbutton%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%)
    Local local0%
    Select arg6
        Case $01
            local0 = copyentity(buttonkeyobj, $00)
        Case $02
            local0 = copyentity(buttonscannerobj, $00)
        Case $03
            local0 = copyentity(buttoncodeobj, $00)
        Default
            local0 = copyentity(buttonobj, $00)
    End Select
    positionentity(local0, arg0, arg1, arg2, $00)
    rotateentity(local0, arg3, arg4, arg5, $00)
    Return local0
    Return $00
End Function
