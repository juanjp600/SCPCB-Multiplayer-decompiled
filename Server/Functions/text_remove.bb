Function text_remove%(arg0%, arg1%)
    player[arg0]\Field52 = (player[arg0]\Field52 + $01)
    Delete player[arg0]\Field44[arg1]
    Return $00
End Function
