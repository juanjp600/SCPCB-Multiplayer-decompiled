Function addframetogun%(arg0.guns, arg1%, arg2%, arg3%)
    Select arg1
        Case $01
            arg0\Field14 = (Float arg2)
        Case $02
            arg0\Field13[$00] = (Float arg2)
            arg0\Field13[$01] = (Float arg3)
        Case $03
            arg0\Field17[$00] = (Float arg2)
            arg0\Field17[$01] = (Float arg3)
        Case $04
            arg0\Field16[$00] = (Float arg2)
            arg0\Field16[$01] = (Float arg3)
        Case $05
            arg0\Field15 = (Float arg2)
    End Select
    Return $00
End Function
