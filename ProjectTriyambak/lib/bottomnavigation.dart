import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'theme.dart';
import 'aboutus.dart';
import 'webScreen.dart';
import 'main_drawer.dart';
// import 'package:provider/provider.dart';

class Bottom extends StatefulWidget {
  Bottom({
    Key key,
  }) : super(key: key);

  @override
  _BottomState createState() => _BottomState();
}

class _BottomState extends State<Bottom> {
  int currentIndex = 1;
  final screens = [AboutUs(), WebScreen(), MainDrawer()];

  void _onItemTapped(int index) {
    setState(() {
      currentIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    final themeProvider = Provider.of<ThemeProvider>(context);
    return Scaffold(
      backgroundColor: Colors.black.withOpacity(0.0),
      extendBody: true,
      appBar: PreferredSize(
          preferredSize: Size.fromHeight(5.0), // here the desired height
          child: AppBar()),
      body: screens[currentIndex],
    );
  }
}
