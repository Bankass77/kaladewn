/** @type {import('tailwindcss').Config} */
const defaultTheme=require('tailwindcss/defaultTheme');
module.exports = {
	purge: [],
	darkMode: false, // or 'Media' or 'class'
  content: ["./src/main/resources/templates/**/*.{html,js}"],
  theme: {
    extend: {
	fontFamily:{
		sans:['Inter var', ...defaultTheme.fontFamily.sans]
	},
},
 variants:{
	extend:{},
},
  },
  plugins: [
	require('@tailwindcss/forms')
],
}
